from utils.dateFormat import DateFormat

class Tratamiento():

    def __init__(self, id, sintoma=None, diagnostico=None, fecha=None, fk_paciente=None, fk_medico=None) -> None:
        
            self.id = id
            self.sintoma = sintoma
            self.diagnostico = diagnostico
            self.fecha = fecha
            self.fk_paciente = fk_paciente
            self.fk_medico = fk_medico

    def to_Json(self):
        return { 

            'id': self.id,
            'sintoma': self.sintoma,
            'diagnostico': self.diagnostico,
            'fecha': DateFormat.convert_date(self.fecha),
            'fk_paciente': self.fk_paciente,
            'fk_medico': self.fk_medico

        }

        