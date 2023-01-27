from database.db import get_connection
from .entities.tratamiento import Tratamiento



class TratamietoModel():

    @classmethod
    def get_tratamientos(self):
        try:
            connection=get_connection()
            tratamientos=[]

            with connection.cursor() as cursor:
                cursor.execute("SELECT * FROM public.sintoma ORDER BY id ASC")
                resultset=cursor.fetchall()



                for row in resultset:
                    tratamiento=Tratamiento(row[0],row[1],row[2],row[3], row[4], row[5])
                    tratamientos.append(tratamiento.to_Json())


            connection.close()
            return tratamientos
        except Exception as ex:
                raise Exception(ex)


##########GET#########################
    @classmethod
    def get_tratamiento(self,id):
        try:
            connection=get_connection()
           

            with connection.cursor() as cursor:
                cursor.execute("SELECT * FROM public.sintoma WHERE id = %s",(id,))
                row=cursor.fetchone()



                tratamiento = None
                if row != None:

                    tratamiento = Tratamiento(row[0],row[1],row[2],row[3],row[4], row[5])
                tratamiento = tratamiento.to_Json()

            connection.close()
            return tratamiento
        except Exception as ex:
                raise Exception(ex)

##########POST#########################
    @classmethod
    def add_tratamiento(self,tratamiento):
        try:
            connection=get_connection()
           

            with connection.cursor() as cursor:
                cursor.execute("INSERT INTO public.sintoma (id, sintoma, diagnostico, fechas, fk_paciente, fk_medico) VALUES (%s, %s, %s, %s, %s, %s)",(tratamiento.id, tratamiento.sintoma, tratamiento.diagnostico, tratamiento.fecha, tratamiento.fk_paciente, tratamiento.fk_medico))
                
            affected_rows=cursor.rowcount
            connection.commit()

            connection.close()
            return affected_rows
        except Exception as ex:
                raise Exception(ex)

##########PUT#########################
    @classmethod
    def update_tratamiento(self,tratamiento):
        try:
            connection = get_connection()
           

            with connection.cursor() as cursor:
                cursor.execute("UPDATE public.sintoma SET sintoma = %s, diagnostico = %s, fechas = %s, fk_paciente= %s, fk_medico = %s  WHERE id = %s" ,( tratamiento.sintoma, tratamiento.diagnostico, tratamiento.fecha, tratamiento.fk_paciente, tratamiento.fk_medico, tratamiento.id))
                
            affected_rows=cursor.rowcount
            connection.commit()

            connection.close()
            return affected_rows
        except Exception as ex:
                raise Exception(ex)



##########DELETE#########################
    @classmethod
    def delete_tratamiento(self, tratamiento):
        try:
            connection = get_connection()
           

            with connection.cursor() as cursor:
                cursor.execute("DELETE FROM public.sintoma WHERE id = %s", (tratamiento.id,))
                affected_rows = cursor.rowcount
                connection.commit()

            connection.close()
            return affected_rows
        except Exception as ex:
                raise Exception(ex)
