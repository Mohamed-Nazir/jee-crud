function confirmSuppression() {
    return confirm("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
}

function showSuccessNotification(message) {
    alert(message);
}


function checkAndUpdateSuccessNotification() {
    var urlParams = new URLSearchParams(window.location.search);
    var successParam = urlParams.get('success');

    if (successParam === 'true') {
        showSuccessNotification('La modification a réussi !');
    }
}
