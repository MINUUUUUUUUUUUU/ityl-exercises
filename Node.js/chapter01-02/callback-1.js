const order = (coffee, callback) => {
  console.log(coffee);
  setTimeout(() => {
    callback(coffee);
  }, 3000);
};

const display = (result) => {
  console.log(result + '완료');
};

order('americano', display);
