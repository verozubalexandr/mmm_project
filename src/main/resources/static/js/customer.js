//elements
let $databaseSpan          = document.querySelector("#db-info");
let $databaseContainer     = document.querySelector(".item");
let $editBtn               = document.querySelector(".customer-edit");
let $deleteBtn             = document.querySelector(".customer-delete");
let $deleteConfirm         = document.querySelector(".customer-delete-confirm");
let $deleteDiscard         = document.querySelector(".customer-delete-discard");
let $modalOverlay          = document.querySelector(".modal-overlay")
let $statusOverlay         = document.querySelector(".status-overlay");
let $statusSuccessText     = document.querySelector(".success-message");
let $statusErrorText       = document.querySelector(".error-message");
let $statusSeenBtn         = document.querySelector(".status-seen");

//variables
let database               = $databaseSpan.innerHTML;

//constants
const url                  = 'http://localhost:8080/delete/deleted';

//parse database
database = JSON.parse(database);

//create page structure
window.addEventListener('onload', reDraw());

//edit redirect event
$editBtn.addEventListener('click', function () {
    document.location.href = '/edit?id='+ (window.location.href).match(/\d{1,}/g)[((window.location.href).match(/\d{1,}/g).length) - 1];
})

//delete modal show
$deleteBtn.addEventListener('click', async function () {
    if ($modalOverlay.classList.contains("hide-modal")) {
        $modalOverlay.classList.remove("hide-modal");
    } else {
        $modalOverlay.classList.add("hide-modal");
    }
});

//delete confirm || cancel
$deleteConfirm.addEventListener('click', async function () {
    $modalOverlay.classList.add("hide-modal")

    //request data
    const data = {
        id: (window.location.href).match(/\d{1,}/g)[((window.location.href).match(/\d{1,}/g).length) - 1]
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

//show status
$statusSeenBtn.addEventListener('click', function () {
    $statusOverlay.classList.add("hide-status");
    document.location.href = '/search';
});

//cancel delete
$deleteDiscard.addEventListener('click', function () {
    $modalOverlay.classList.add("hide-modal");
});

//create information page structure
function reDraw() {
    let template =
        '<div class="data-type">' +
            'Name: ' +
            '<span class="data-type-info">'
                + getPropertyValue(database,"name")[0].toUpperCase()
                + getPropertyValue(database,"name").slice(1).toLowerCase() +
            ' </span>' +
        '</div>'
    +
    '<div class="data-type">' +
        'Last name: ' +
            '<span class="data-type-info">'
                + getPropertyValue(database,"lastName")[0].toUpperCase()
                + getPropertyValue(database,"lastName").slice(1).toLowerCase() +
            ' </span>' +
        '</div>'
    +
    '<div class="data-type">' +
        'Patronymic: ' +
            '<span class="data-type-info">'
                    + getPropertyValue(database,"patronymic")[0].toUpperCase()
                    + getPropertyValue(database,"patronymic").slice(1).toLowerCase() +
            ' </span>' +
        '</div>'
    +
    '<div class="data-type">' +
        'City: ' +
        '<span class="data-type-info">'
            + getPropertyValue(database,"city")[0].toUpperCase()
            + getPropertyValue(database,"city").slice(1).toLowerCase() +
        ' </span>' +
    '</div>'
    +
    '<div class="data-type">' +
        'Street: ' +
        '<span class="data-type-info">'
                + getPropertyValue(database,"street")[0].toUpperCase()
                + getPropertyValue(database,"street").slice(1).toLowerCase() +
        ' </span>' +
    '</div>'
    +
    '<div class="data-type">' +
        'House number: ' +
        '<span class="data-type-info">'
            + getPropertyValue(database,"houseNumber") +
        ' </span>' +
    '</div>'
    +
    '<div class="data-type">' +
        'Apartment number:   ' +
        '<span class="data-type-info">'
            + getPropertyValue(database,"apartmentNumber") +
        ' </span>' +
    '</div>'
    +
    '<div class="data-type">' +
        'Deposit: ' +
        '<span class="data-type-info">'
            + getPropertyValue(database,"deposit") +
        ' </span>' +
        ' UAH ' +
    '</div>'
    +
    '<div class="data-type">' +
        'Auto Prolongation: ' +
        '<span class="data-type-info">'
            + ((getPropertyValue(database,"autoProlongation") == true) ? 'On' : 'Off') +
        '</span> ' +
    '</div>'
    +
    '<div class="data-type">' +
        'Term: ' +
        '<span class="data-type-info">'
            + getPropertyValue(database,"term") +
        ' </span>' +
        'month' +
    '</div>'
    +
    '<div class="data-type">' +
        'Contract number: ' +
        '<span class="data-type-info">'
            + getPropertyValue(database,"contractNumber") +
        ' </span>' +
    '</div>';

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