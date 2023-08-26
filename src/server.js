const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const PORT = 3001;

app.use(bodyParser.json());

app.post('/submit-talents', (req, res) => {
    console.log(req.body);  // This will log the submitted data to the console
    res.send({ status: 'success' });
});


app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});