'use strict';

function completeCategoryRow(category, tbody) {
    const row = document.createElement("tr");
    const id = document.createElement("td");
    id.innerHTML = category.id;
    const name = document.createElement("td");
    name.innerHTML = category.name;
    row.appendChild(id);
    row.appendChild(name);
    tbody.appendChild(row);
}

const completeTable = data => {
    const tbody = document.querySelector("tbody");
    data.forEach(category => {
        completeCategoryRow(category, tbody);
    });
    document.querySelector("table").removeAttribute('hidden');
}

const handler = () => fetch("/index", {
    method: "GET",
    headers: {
        'Content-type': 'application/json; charset=utf-8'
    }
}).then(response => response.json())
    .then(data => completeTable(data));

document.querySelector("button").addEventListener('click', handler);