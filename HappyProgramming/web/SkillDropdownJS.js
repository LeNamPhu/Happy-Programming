VirtualSelect.init({
    ele: '#sample-select',
    options: [
        {label: 'Options 5', value: '1'},
        {label: 'Options 4', value: '2'},
        {label: 'Options 3', value: '3'},
        {label: 'Options 2', value: '4'},
        {label: 'Options 1', value: '5'},
        {label: 'Options 6', value: '6'},
        {label: 'Options 7', value: '7'},
        {label: 'Options 8', value: '8'},
        {label: 'Options 9', value: '9'},


    ],
    multiple: true,
    search: true,
    maxValues: 3,
    setValueAsArray:true,
    showValueAsTags: true,
});
document.querySelector('#sample-select').addEventListener('change', function() {
  document.querySelector('#sample-select').value;
  
});

