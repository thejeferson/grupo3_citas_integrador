
from flask import Blueprint, jsonify, request

#Emtities
from models.entities.tratamiento import Tratamiento

#Modelos
from models.tratamientoModel import TratamietoModel



main=Blueprint('tratamiento_blueprint',__name__)
#################GET###########
@main.route('/')
def get_tratamientos():
    try:

        tratamientos=TratamietoModel.get_tratamientos()
        return jsonify(tratamientos)
    except Exception as ex:
        return jsonify({'message': str(ex)}),500

@main.route('/<id>')     
def get_tratamiento(id):

    try:
        tratamiento = TratamietoModel.get_tratamiento(id)
        if tratamiento != None:
            return jsonify(tratamiento)
        else:
            return jsonify({}), 404
    except Exception as ex:
        return jsonify({'message': str(ex)}), 500

#################POST###########
@main.route('/add', methods=['POST'])     
def add_tratamiento():

    try:
            id = request.json ['id']
            sintoma = request.json['sintoma']
            diagnostico = request.json['diagnostico']
            fecha = request.json['fecha']
            id_paciente = request.json['id_paciente']
            id_medico = request.json['id_medico']
            tratamiento=Tratamiento(str(id), sintoma, diagnostico, fecha, id_paciente, id_medico)

            affected_rows= TratamietoModel.add_tratamiento(tratamiento)

            if affected_rows == 1:
                return jsonify(tratamiento.id)
            else:
                return jsonify({'message': "Error en la insert"}), 500

    except Exception as ex:
        return jsonify({'message': str(ex)}), 500


#################UPDATE###########

@main.route('/update/<id>', methods=['PUT'])     
def update_tratamiento(id):

    try:
            sintoma = request.json['sintoma']
            diagnostico = request.json['diagnostico']
            fecha = request.json['fecha']
            id_paciente = request.json['id_paciente']
            id_medico = request.json['id_medico']
            tratamiento=Tratamiento(id, sintoma, diagnostico, fecha, id_paciente, id_medico)

            affected_rows= TratamietoModel.update_tratamiento(tratamiento)

            if affected_rows == 1:
                return jsonify(tratamiento.id)
            else:
                return jsonify({'message': "Error no tratamiento UPDATE"}), 404

    except Exception as ex:
        return jsonify({'message': str(ex)}), 500







#################DELETE###########
@main.route('/delete/<id>', methods=['DELETE'])     
def delete_tratamiento(id):

    try:
            tratamiento = Tratamiento(id)

            affected_rows = TratamietoModel.delete_tratamiento(tratamiento)


            if affected_rows == 1:
                return jsonify(tratamiento.id)
            else:
                return jsonify({'message': "Error tratamiento  NO delete"}), 404

    except Exception as ex:
        return jsonify({'message': str(ex)}), 500
    
    