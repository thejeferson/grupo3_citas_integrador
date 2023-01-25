from flask import Flask
from config import config
from flask_cors import CORS
#RUTAS
from routes import tratamiento


app=Flask(__name__)

CORS(app,resources={"*":{"origins":"http://localhost:4200"}})


def pagina_not_found(error):
    return "<h1>Pagina Inicio Citas!!</h1>", 404


if __name__=='__main__':
    app.config.from_object(config['development'])

    #Blueprints


    app.register_blueprint(tratamiento.main,url_prefix='/api/tratamiento')

#Error handlers
    app.register_error_handler(404, pagina_not_found)
    app.run()