import order from './pizza_order.mjs';

//const pizzaList = ['치즈피자', '불고기피자', '페퍼로니피자'];
order('페퍼로니피d자')
  .then((fn) => {
    fn();
  })
  .catch((err) => {
    console.log(err);
  });
