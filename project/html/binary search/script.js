const numberForm = document.getElementById('numberForm');
const numberInput = document.getElementById('numberInput');
const confirmBtn = document.getElementById('confirmBtn');
const sortBtn = document.getElementById('sortBtn');
const binarySearchBtn = document.getElementById('binarySearchBtn');
const nextStepBtn = document.getElementById('nextStepBtn');
const searchInput = document.getElementById('searchInput');
const userList = document.getElementById('userList');
const sortedList = document.getElementById('sortedList');
const binarySearchList = document.getElementById('binarySearchList');
const userNumbers = [];
const sortedNumbers = [];
let binarySearchState = null;

confirmBtn.addEventListener('click', function() {
    const enteredNumber = numberInput.value;
    if (enteredNumber !== "") {
        userNumbers.push(Number(enteredNumber));
        updateList(userList, userNumbers);
        numberInput.value = "";
    }
});

numberInput.addEventListener('keydown', function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        confirmBtn.click();
    }
});

sortBtn.addEventListener('click', function() {
    sortedNumbers.length = 0; // Clear the array
    sortedNumbers.push(...userNumbers);
    sortedNumbers.sort((a, b) => a - b);
    updateList(sortedList, sortedNumbers);
    resetBinarySearch();
});

binarySearchBtn.addEventListener('click', function() {
    const searchNumber = Number(searchInput.value);
    if (!isNaN(searchNumber)) {
        performBinarySearch(binarySearchList, sortedNumbers, searchNumber);
    } else {
        binarySearchList.innerHTML = "<div class='binary-search-item'>Invalid input.</div>";
    }
});

nextStepBtn.addEventListener('click', performNextStep);

function updateList(listElement, numbers) {
    let listHtml = "";
    for (const num of numbers) {
        listHtml += `<li>${num}</li>`;
    }
    listElement.innerHTML = listHtml;
}

function performBinarySearch(listElement, arr, target) {
    binarySearchState = {
        listElement: listElement,
        arr: arr,
        target: target,
        left: 0,
        right: arr.length - 1,
        mid: -1,
        steps: []
    };
    resetBinarySearch();
    nextStepBtn.disabled = false;
}

function resetBinarySearch() {
    if (binarySearchState) {
        binarySearchState.listElement.innerHTML = "";
        animateInitialBlink(binarySearchState.listElement, binarySearchState.arr);
        nextStepBtn.disabled = false;
        binarySearchState.steps = [];
    }
}

async function performNextStep() {
    if (!binarySearchState || binarySearchState.left > binarySearchState.right) {
        nextStepBtn.disabled = true;
        return;
    }

    binarySearchState.mid = Math.floor((binarySearchState.left + binarySearchState.right) / 2);
    binarySearchState.steps.push(binarySearchState.mid);

    listElement.innerHTML = ""; // Clear previous animation
    animateSearch(binarySearchState.listElement, binarySearchState.arr, binarySearchState.left, binarySearchState.right, binarySearchState.mid, binarySearchState.target);

    binarySearchState.left = binarySearchState.arr[binarySearchState.mid] < binarySearchState.target ? binarySearchState.mid + 1 : binarySearchState.left;
    binarySearchState.right = binarySearchState.arr[binarySearchState.mid] > binarySearchState.target ? binarySearchState.mid - 1 : binarySearchState.right;

    if (binarySearchState.arr[binarySearchState.mid] === binarySearchState.target) {
        binarySearchState.listElement.innerHTML = `<div class='binary-search-item center-element'>${binarySearchState.arr[binarySearchState.mid]}</div>`;
        nextStepBtn.disabled = true;
    }

    await sleep(1000);
}

async function animateInitialBlink(listElement, arr) {
    for (const num of arr) {
        const listItem = document.createElement("div");
        listItem.textContent = num;
        listItem.classList.add("binary-search-item", "highlight-animation");
        listElement.appendChild(listItem);
    }
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function animateSearch(listElement, arr, left, right, mid, target) {
    for (let i = left; i <= right; i++) {
        const listItem = document.createElement("div");
        listItem.textContent = arr[i];
        if (i === mid) {
            listItem.classList.add("binary-search-item", "center-element");
        } else if (arr[i] === target) {
            listItem.classList.add("binary-search-item", "highlight-animation");
        } else {
            listItem.classList.add("binary-search-item");
        }
        listElement.appendChild(listItem);
        await sleep(500);
    }
}

