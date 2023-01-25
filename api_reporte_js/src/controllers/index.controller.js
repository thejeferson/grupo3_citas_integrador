const {Pool} = require('pg');

const pool = new Pool({
    host: 'localhost',
    user: 'postgres',
    password: 'postgressql',
    database: 'microservicio_citas'
});


const getUsers = async (req, res) => {
    const response = await pool.query('SELECT * FROM reporte');
    res.status(200).json(response.rows);
};

const getUserById = async (req, res) => {
    const id = req.params.id;
    const response = await pool.query('SELECT * FROM reporte WHERE id= $1', [id]);
    res.json(response.rows);
};

const createUser = async (req, res) => {
    const {titulo, fecha, num_reporte, id_medico, id_sintoma, id_tratamiento, id_paciente} = req.body;

    const response = await pool.query('INSERT INTO reporte (titulo, fecha, num_reporte,id_medico,id_sintoma, id_tratamiento, id_paciente) VALUES ($1, $2, $3, $4, $5, $6, $7)', [titulo, fecha, num_reporte, id_medico, id_sintoma, id_tratamiento, id_paciente]);
    res.send('reporte creado')

};

const updateUser = async (req, res) => {
    const id = req.params.id;
    const {titulo, fecha, num_reporte} = req.body;
    const response = await pool.query('UPDATE reporte SET titulo = $1, fecha = $2, num_reporte = $3 WHERE id = $4', [
        titulo,
        fecha,
        num_reporte,
        id
    ]);
    res.json('reporte Update');
}

const deleteUser = async (req, res) => {
    const id = req.params.id;
    const response = await pool.query('DELETE FROM reporte WHERE id = $1', [id]);
    res.json(`User ${id} deleted`)
};


module.exports ={
    getUsers,
    getUserById,
    createUser,
    deleteUser,
    updateUser
}