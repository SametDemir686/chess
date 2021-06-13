const perspective = 'BLACK';
let selectedPiece = null;

function init() {
    updateBoard();
    document.getElementById("board").onclick = onClick;
}

function updateBoard() {
    let response = httpGet('http://localhost:8080/match/getBoard?perspective=' + perspective);
    for (let i = 0; i < response.length; i++) {
        for (let j = 0; j < response[i].length; j++) {
            document.getElementById((i + 1) + "" + (j + 1)).innerHTML = response[i][j].htmlCode;
        }
    }
}

function onClick(e) {
    if (selectedPiece != null) {
        const moveTo = toA1Notataion(e.path[0].id);
        httpPost('http://localhost:8080/match/move?from=' + selectedPiece + '&to=' + moveTo);
        updateBoard();
        console.log("move from", selectedPiece, "to", moveTo);
        selectedPiece = null;
    } else {
        selectedPiece = toA1Notataion(e.path[0].id);
        console.log("selected", selectedPiece);
    }
}

function toA1Notataion(id) {
    if (perspective === 'WHITE') {
        let vertice = String.fromCharCode('A'.codePointAt(0) + parseInt(id[1]) - 1);
        let horizon = 9 - id[0];
        return vertice + horizon;
    } else {
        let vertice = String.fromCharCode('H'.codePointAt(0) - parseInt(id[1]) + 1);
        let horizon = id[0];
        return vertice + horizon;
    }
}

function httpGet(theUrl) {
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", theUrl, false);
    xmlHttp.withCredentials = true;
    xmlHttp.send(null);
    return JSON.parse(xmlHttp.responseText);
}

function httpPost(theUrl) {
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", theUrl, false);
    xmlHttp.withCredentials = true;
    xmlHttp.send(null);
}
