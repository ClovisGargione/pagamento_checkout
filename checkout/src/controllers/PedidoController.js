const Pedidos = require('../models/Pedidos')

module.exports = {
    async store(req, res) {
        const { item, quantidade, pagamento, preco, status } = req.body;
        const pedido = await Pedidos.create({item, quantidade, pagamento, preco, status});
        return res.json(pedido);
    },

    async find(req, res) {
        const pedido = await Pedidos.findByPk(req.params.pedidoId);
        return res.json(pedido);
    }
}