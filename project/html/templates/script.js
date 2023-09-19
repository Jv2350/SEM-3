const arrayContainer = document.getElementById('arrayContainer');
const arrayInput = document.getElementById('arrayInput');
const targetInput = document.getElementById('target');
let array = [];
let animationSpeed = 1000; // in milliseconds

function createArrayElements() {
  arrayContainer.innerHTML = '';
  for (let num of array) {
    const element = document.createElement('div');
    element.textContent = num;
    element.classList.add('array-element');
    arrayContainer.appendChild(element);
  }
}

function addToArray() {
  const num = parseInt(arrayInput.value);
  if (!isNaN(num)) {
    array.push(num);
    createArrayElements();
    arrayInput.value = '';
  }
}

function linearSearch() {
  const target = parseInt(targetInput.value);
  let found = false;
  let index = -1;

  for (let i = 0; i < array.length; i++) {
    setTimeout(() => {
      const element = arrayContainer.children[i];
      element.style.backgroundColor = 'yellow';
      if (array[i] === target) {
        found = true;
        index = i;
        element.style.backgroundColor = 'green';
      } else {
        element.style.backgroundColor = 'red';
      }

      if (i === array.length - 1) {
        setTimeout(() => {
          if (found) {
            alert(`Target ${target} found at index ${index}`);
          } else {
            alert(`Target ${target} not found`);
          }
          resetColors();
        }, animationSpeed);
      }
    }, i * animationSpeed);
  }
}

function resetColors() {
  for (let i = 0; i < array.length; i++) {
    setTimeout(() => {
      arrayContainer.children[i].style.backgroundColor = 'white';
    }, i * animationSpeed);
  }
}

createArrayElements();
