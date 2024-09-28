const express = require('express');
const PedidoController = require('../src/controllers/PedidoController')

const routes = express.Router();

routes.post('/rest/checkout/pedido', PedidoController.store);
routes.get('/rest/checkout/pedido/:pedidoId', PedidoController.find);

module.exports = routes;