const customExpress = require('./config/CustomExpress');
const app = customExpress();
const connection = require('./store/connection');
const tables = require('./store/database/tables');

connection.connect(error => {
  if(error) {
    console.log(error);
  } else {
    console.log('Connection created');
    tables.create(connection);
    app.listen(3001,() => {
      console.log('Connected');
    })
  }
})