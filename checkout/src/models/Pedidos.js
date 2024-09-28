const { Model, DataTypes } = require('sequelize');

class Pedidos extends Model {
    static init(sequelize){
        super.init({
            item: DataTypes.STRING,
            quantidade: DataTypes.INTEGER,
            pagamento: DataTypes.BOOLEAN,
            preco: DataTypes.STRING,
            status: DataTypes.STRING,
        }, {
            sequelize
        })
    }
}

module.exports = Pedidos;