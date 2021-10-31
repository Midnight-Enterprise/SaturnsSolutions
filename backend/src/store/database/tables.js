class Tables {
  create(connection) {
    this.connection = connection;
    this.createMoney();
  }
  createMoney() {
    const sql = `CREATE TABLE IF NOT EXISTS Money (id int NOT NULL AUTO_INCREMENT, 
      quantity int NOT NULL, name varchar(30), deposit DECIMAL(5,2), withdraw DECIMAL(5,2))`;
    this.connection.query(sql, error => {
      if(error) {
        console.log(error);
      } else {
        console.log('Money table created successfully');
      }
    })
  };
}

module.exports = new Tables;