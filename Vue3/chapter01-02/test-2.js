const arr1 = [1, 2, 3];
const arr2 = arr1;

console.log('arr1: ', arr1);
console.log('arr2: ', arr2);

arr2[0] = 100;

console.log('arr1: ', arr1);
console.log('arr2: ', arr2);

const arr3 = [100, 200, 300];
const arr4 = [...arr3];

console.log('arr3:', arr3);
console.log('arr4:', arr4);

arr4[0] = 99999;

console.log('arr3:', arr3);
console.log('arr4:', arr4);
