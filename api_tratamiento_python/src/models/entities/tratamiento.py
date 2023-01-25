from utils.dateFormat import DateFormat

class Tratamiento():

    def __init__(self,id, nombre=None, descripcion=None, fecha=None, id_paciente=None, id_medico=None) -> None:
        
            self.id = id
            self.nombre = nombre
            self.descripcion = descripcion
            self.fecha = fecha
            self.id_paciente = id_paciente
            self.id_medico = id_medico


    def to_Json(self):
        return { 
            'id': self.id,
            'nombre': self.nombre,
            'descripcion': self.descripcion,
            'fecha': DateFormat.convert_date(self.fecha),
            'id_paciente': self.id_paciente,
            'id_medico': self.id_medico

        }