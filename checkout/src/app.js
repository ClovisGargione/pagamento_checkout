const express = require('express');
const bodyParser = require('body-parser');
const routes = require('./routes');
require('./database')   

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false}));
app.use(routes);

app.listen(3000, () => {console.log("Server running!")});

module.exports = app;