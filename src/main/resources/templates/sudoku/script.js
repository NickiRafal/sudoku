document.addEventListener('DOMContentLoaded', () => {
    const table = document.getElementById('sudoku-board');
    const apiUrl = 'http://localhost:8080/sudokuApi'; // Zmień na rzeczywisty adres URL swojego backendu

    function updateSudokuBoard(board) {
        table.innerHTML = '';

        for (let i = 0; i < 9; i++) {
            const row = document.createElement('tr');
            for (let j = 0; j < 9; j++) {
                const cell = document.createElement('td');
                cell.textContent = board[i][j] !== 0 ? board[i][j] : '';
                if (board[i][j] === 0) {
                    cell.addEventListener('click', () => {
                        const value = prompt('Wprowadź cyfrę (1-9):');
                        if (value && !isNaN(value) && value >= 1 && value <= 9) {
                            cell.textContent = value;
                            updateCellValue(i, j, value);
                        }
                    });
                }
                row.appendChild(cell);
            }
            table.appendChild(row);
        }
    }

    function updateCellValue(row, col, value) {
        fetch(apiUrl + '/move', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ row, col, value })
        })
            .then(response => response.json())
            .then(data => {
                updateSudokuBoard(data.board);
            })
            .catch(error => console.error(error));
    }

    // Pobranie planszy Sudoku przy starcie strony
    fetch(apiUrl + '/board')
        .then(response => response.json())
        .then(data => {
            updateSudokuBoard(data.board);
        })
        .catch(error => console.error(error));
});
