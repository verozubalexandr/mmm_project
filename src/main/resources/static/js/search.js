//elements
let $databaseSpan            = document.querySelector("#search-db-info");
let $databaseContainer       = document.querySelector(".datalist-container");
let $searchByLastnameInput   = document.querySelector("#contract-lastname");
let $searchByDepositInput    = document.querySelector("#deposit");
let $searchByTermInput       = document.querySelector("#term");
let $byLastnameBtn           = document.querySelector("#by-lastname");
let $byDepositBtn            = document.querySelector("#by-deposit");
let $byTermBtn               = document.querySelector("#by-term");
let $alertNotFound           = document.querySelector(".not-found-alert");

//database
let database                 = $databaseSpan.innerHTML;
database                     = JSON.parse(database);

//variables
let foundCheck               = false;

//constants
const regex                  = /[.?!)(,:_]/g;
const regexNumber            = /[?!)(,:_A-Za-zа-яА-ЯЁёІіЇїҐґЄє']/g;

reDraw();
//search by lastname
$byLastnameBtn.addEventListener('click', function () {
    $byLastnameBtn.classList.add("button-search-mode-active");
    $byDepositBtn.classList.remove("button-search-mode-active");
    $byTermBtn.classList.remove("button-search-mode-active");
    $searchByTermInput.classList.add("hide");
    $searchByDepositInput.classList.add("hide");
    $searchByLastnameInput.classList.remove("hide");
    $alertNotFound.classList.add("hide");
    clearInput();
    clearResults();
});

//search by deposit (>>x)
$byDepositBtn.addEventListener('click', function () {
    $byDepositBtn.classList.add("button-search-mode-active");
    $byTermBtn.classList.remove("button-search-mode-active");
    $byLastnameBtn.classList.remove("button-search-mode-active");
    $searchByTermInput.classList.add("hide");
    $searchByLastnameInput.classList.add("hide");
    $searchByDepositInput.classList.remove("hide");
    $alertNotFound.classList.add("hide");
    clearInput();
    clearResults();
});

//search by term (>>x)
$byTermBtn.addEventListener('click', function () {
    $byTermBtn.classList.add("button-search-mode-active");
    $byLastnameBtn.classList.remove("button-search-mode-active");
    $byDepositBtn.classList.remove("button-search-mode-active");
    $searchByDepositInput.classList.add("hide");
    $searchByLastnameInput.classList.add("hide");
    $searchByTermInput.classList.remove("hide");
    $alertNotFound.classList.add("hide");
    clearInput();
    clearResults();
});

//by lastname search engine
$searchByLastnameInput.addEventListener('input', function () {
    if ($searchByLastnameInput.value.trim().replaceAll(regex, "").toLowerCase()) {
        for (let i = 0; i < database.length; i++) {
            let $dataList = document.querySelectorAll(".datalist-container .datalist-item");
            if (getPropertyValue(database[i], "lastName")
                .search($searchByLastnameInput.value
                    .trim().replaceAll(regex, "").toLowerCase())) {
                $dataList[i].classList.add("hide");
            } else {
                $dataList[i].classList.remove("hide");
                foundCheck = true;
            }
        }
        checkFound();
    } else {
        $alertNotFound.classList.add("hide");
        clearResults();
    }
    foundCheck = false;
});

//by deposit search engine
$searchByDepositInput.addEventListener('input', function () {
    if ($searchByDepositInput.value.trim().replaceAll(regexNumber, "")) {
        for (let i = 0; i < database.length; i++) {
            let $dataList = document.querySelectorAll(".datalist-container .datalist-item");
            if (getPropertyValue(database[i], "deposit") > $searchByDepositInput.value
                .trim().replace(",", ".").replaceAll(regexNumber, "")) {
                $dataList[i].classList.remove("hide");
                foundCheck = true;
            } else {
                $dataList[i].classList.add("hide");
            }
        }
        checkFound();
    } else {
        $alertNotFound.classList.add("hide");
        clearResults();
    }
    foundCheck = false;
});

//by term search engine
$searchByTermInput.addEventListener('input', function () {
    if ($searchByTermInput.value.trim().replaceAll(regexNumber, "")) {
        for (let i = 0; i < database.length; i++) {
            let $dataList = document.querySelectorAll(".datalist-container .datalist-item");
            if (getPropertyValue(database[i], "term") > $searchByTermInput.value
                .trim().replace(",", ".").replaceAll(regexNumber, "")) {
                $dataList[i].classList.remove("hide");
                foundCheck = true;
            } else {
                $dataList[i].classList.add("hide");
            }
            checkFound();
        }
    } else {
        $alertNotFound.classList.add("hide");
        clearResults();
    }
    foundCheck = false;
});


//create page structure
function reDraw() {
    let template = '';
    for (let i = 0; i < database.length; i++) {
        template +=
            ' <li class="datalist-item hide">'
                + getPropertyValue(database[i], "lastName") + " " + '('
                + getPropertyValue(database[i], "contractNumber")
                + ')<a href="/customer?id=' + i + '">' +
                    'info' +
                '</a>' +
            '</li>';
    }

    $databaseContainer.innerHTML = template;
}

//get value by field
function getPropertyValue(obj, dataToRetrieve) {
    return dataToRetrieve
        .split('.')
        .reduce(function (o, k) {
            return o && o[k];
        }, obj)
}

//clear search results
function clearResults() {
    let $dataList = document.querySelectorAll(".datalist-container .datalist-item");
    for (let i = 0; i < database.length; i++) {
        $dataList[i].classList.add("hide");
    }
}

//clear inputs
function clearInput() {
    $searchByLastnameInput.value = "";
    $searchByDepositInput.value = "";
    $searchByTermInput.value = "";
}

//check search results
function checkFound() {
    if (foundCheck === true) {
        $alertNotFound.classList.add("hide");
    } else {
        $alertNotFound.classList.remove("hide")
    }
}

