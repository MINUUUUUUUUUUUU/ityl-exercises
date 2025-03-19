/* 전역 범위 this == 전역 객체 */
console.log('전역 범위 : ', this);

/* 객체 내에서 this == 해당 객체 */
let obj = {
  result: 0,
  add: function (x, y) {
    // this == obj
    console.log('객체 내 this : ', this);
    this.result = x + y;
  },
};

obj.add(3, 4);
console.log('obj.result : ', obj.result);
