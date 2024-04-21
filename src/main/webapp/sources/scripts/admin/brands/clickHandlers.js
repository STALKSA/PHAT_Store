'use strict';

const API = "/admin/brands";

const update = (e) => fetch(API, {
    method: "PUT",
    headers: {
        'Content-type': 'application/json; charset=utf-8'
    },
    body: {
      id: getUpdId(e),
      name: getUpdName(e)
    }
}).then(response => response.json())
    .then(data => completeTable(data));

const getUpdId = (e) => {
    return e.target.parent().previousElementSibling.previousElementSibling.innerHTML;
}

const getUpdName = (e) => {
    return e.target.parent().previousElementSibling.innerHTML;
}

const deleteRequest = (e) => fetch(API, {
    method: "DELETE",
    headers: {
        'Content-type': 'application/json; charset=utf-8'
    },
    body: {
        id: getDeleteId(e),
    }
}).then(response => response.json())
    .then(data => completeTable(data));

const getDeleteId = (e) => {
    return e.target.parent().previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
}