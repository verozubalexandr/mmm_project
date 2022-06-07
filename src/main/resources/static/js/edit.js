//elements
let $nameEditInput                    = document.querySelector("#name-edit");
let $lastNameEditInput                = document.querySelector("#last-name-edit");
let $patronymicEditInput              = document.querySelector("#patronymic-edit");
let $contractNumberEditInput          = document.querySelector("#contract-number-edit");
let $cityEditInput                    = document.querySelector("#city-edit");
let $streetEditInput                  = document.querySelector("#street-edit");
let $autoProlongationEditInput        = document.querySelector("#auto-prolongation-edit");
let $houseNumberEditInput             = document.querySelector("#house-number-edit");
let $apartmentNumberEditInput         = document.querySelector("#apartment-number-edit");
let $depositEditInput                 = document.querySelector("#deposit-edit");
let $termEditInput                    = document.querySelector("#term-edit");
let $saveBtn                          = document.querySelector(".customer-save");
let $databaseSpan                     = document.querySelector("#db-info");
let $statusOverlay                    = document.querySelector(".status-overlay");
let $statusSuccessText                = document.querySelector(".success-message");
let $statusErrorText                  = document.querySelector(".error-message");
let $statusSeenBtn                    = document.querySelector(".status-seen");

//parse database string
let database                          = $databaseSpan.innerHTML;
database                              = JSON.parse(database);

//variables
let editedName                        = getPropertyValue(database, "name");
let editedLastName                    = getPropertyValue(database, "lastName");
let editedPatronymic                  = getPropertyValue(database, "patronymic");
let editedContractNumber              = getPropertyValue(database, "contractNumber");
let editedAutoProlongation            = getPropertyValue(database, "autoProlongation");
let editedCity                        = getPropertyValue(database, "city");
let editedStreet                      = getPropertyValue(database, "street");
let editedHouseNumber                 = getPropertyValue(database, "houseNumber");
let editedApartmentNumber             = getPropertyValue(database, "apartmentNumber");
let editedDeposit                     = getPropertyValue(database, "deposit");
let editedTerm                        = getPropertyValue(database, "term");

//constants
const regex                           = /[.?!)(,:_\n\t]/g;
const regexNumber                     = /[?!)(,:_A-Za-zа-яА-ЯЁёІіЇїҐґЄє\n\t\s']/g;
const regexContract                   = /[?!).(,:_A-Za-zа-яА-ЯЁёІіЇїҐґЄє\n\t\s']/g;
const url                             = 'http://localhost:8080/save/saved';

//fill placeholders
$nameEditInput.placeholder            = editedName[0].toUpperCase() + editedName.slice(1).toLowerCase();
$lastNameEditInput.placeholder        = editedLastName[0].toUpperCase() + editedLastName.slice(1).toLowerCase();
$patronymicEditInput.placeholder      = editedPatronymic[0].toUpperCase() + editedPatronymic.slice(1).toLowerCase();
$autoProlongationEditInput.checked    = editedAutoProlongation;
$contractNumberEditInput.placeholder  = editedContractNumber;
$cityEditInput.placeholder            = editedCity[0].toUpperCase() + editedCity.slice(1).toLowerCase();
$streetEditInput.placeholder          = editedStreet[0].toUpperCase() + editedStreet.slice(1).toLowerCase();
$houseNumberEditInput.placeholder     = editedHouseNumber;
$apartmentNumberEditInput.placeholder = editedApartmentNumber;
$depositEditInput.placeholder         = editedDeposit + 'UAH';
$termEditInput.placeholder            = editedTerm + ' month';

//save
$saveBtn.addEventListener('click', async function () {
    //form validation
    if ($nameEditInput.value) {
        if ($nameEditInput.value.replaceAll(regex, ""))
            editedName = $nameEditInput.value.replaceAll(regex, "").toLowerCase()
    }
    if ($lastNameEditInput.value) {
        if ($lastNameEditInput.value.replaceAll(regex, ""))
            editedLastName = $lastNameEditInput.value.replaceAll(regex, "").toLowerCase()
    }
    if ($patronymicEditInput.value) {
        if ($patronymicEditInput.value.replaceAll(regex, ""))
            editedPatronymic = $patronymicEditInput.value.replaceAll(regex, "").toLowerCase()
    }
    if ($cityEditInput.value) {
        if($cityEditInput.value.replaceAll(regex, ""))
            editedCity = $cityEditInput.value.replaceAll(regex, "").toLowerCase()
    }
    if ($streetEditInput.value) {
        if($streetEditInput.value.replaceAll(regex, ""))
            editedStreet = $streetEditInput.value.replaceAll(regex, "").toLowerCase()
    }
    if ($houseNumberEditInput.value) {
        if ($houseNumberEditInput.value.replaceAll(regexContract, ""))
            editedHouseNumber = $houseNumberEditInput.value.trim().replaceAll(regexContract, "")
    }
    if ($apartmentNumberEditInput.value) {
        if ($apartmentNumberEditInput.value.replaceAll(regexContract, ""))
            editedApartmentNumber = $apartmentNumberEditInput.value.replaceAll(regexContract, "")
    }
    if ($depositEditInput.value) {
        if($depositEditInput.value.replaceAll(regexNumber, ""))
            editedDeposit = $depositEditInput.value.replace(",", "").replaceAll(regexNumber, "")
    }
    if ($contractNumberEditInput.value) {
        if($contractNumberEditInput.value.replaceAll(regexContract, ""))
            editedContractNumber = $contractNumberEditInput.value.replaceAll(regexContract, "")
    }
    if ($termEditInput.value) {
        if($termEditInput.value.replaceAll(regexContract, ""))
            editedTerm = $termEditInput.value.replaceAll(regexContract, "")
    }
    editedAutoProlongation = $autoProlongationEditInput.checked

    //request data
    const data = {
        name: (editedName),
        lastName: (editedLastName),
        patronymic: (editedPatronymic),
        city: (editedCity),
        street: (editedStreet),
        houseNumber: (editedHouseNumber),
        apartmentNumber: (editedApartmentNumber),
        deposit: (editedDeposit),
        autoProlongation: (editedAutoProlongation),
        term: (editedTerm),
        id: ((window.location.href).slice(-1)),
        contractNumber: (editedContractNumber)
    };

    //sending a request
    try {
        const response = await fetch(url, {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        //const json = await response.json();
        $statusErrorText.classList.add("hide");
        $statusSuccessText.classList.remove("hide");
        $statusOverlay.classList.remove("hide-status");
    } catch (error) {
        console.error('Err:', error);
        $statusErrorText.classList.remove("hide");
        $statusSuccessText.classList.add("hide");
        $statusOverlay.classList.remove("hide-status");
    }
});

//status show
$statusSeenBtn.addEventListener('click', function () {
    $statusOverlay.classList.add("hide-status");
    document.location.href = '/customer?id=' + (window.location.href).match(/\d{1,}/g)[((window.location.href).match(/\d{1,}/g).length) - 1];
});

//get value by field
function getPropertyValue(obj, dataToRetrieve) {
    return dataToRetrieve
        .split('.')
        .reduce(function (o, k) {
            return o && o[k];
        }, obj)
}