import axios from 'axios';

export const publish = (message) => {
    axios.post('http://localhost:8080/tweet?tweetMessage='+message)
    .then(response => {
        console.log('Tweet Has Been Published');
    })
    .catch(error => {
        console.log('There has been an error');
        console.log(error);
    })
}
