from utils.dateFormat import DateFormat

class Tratamiento():

    def __init__(self,id, nombre=None, descripcion=None, fecha=None, fk_paciente=None, fk_medico=None, fk_sintoma=None) -> None:
        
            self.id = id
            self.nombre = nombre
            self.descripcion = descripcion
            self.fecha = fecha
            self.fk_paciente = fk_paciente
            self.fk_medico = fk_medico
            self.fk_sintoma = fk_sintoma

    def to_Json(self):
        return { 
            'id': self.id,
            'nombre': self.nombre,
            'descripcion': self.descripcion,
            'fecha': DateFormat.convert_date(self.fecha),
            'fk_paciente': self.fk_paciente,
            'fk_medico': self.fk_medico,
            'fk_sintoma': self.fk_sintoma,


        }