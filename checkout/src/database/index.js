const Sequelize = require('sequelize');
const dbConfig = require('../config/database');

const Pedido = require('../models/Pedidos')

const connection = new Sequelize(dbConfig);

Pedido.init(connection);

module.exports = connection;