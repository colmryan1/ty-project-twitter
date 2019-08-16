import React, {Component} from 'react';
import {publish} from './functions';

class myUi extends Component {

    constructor(props) {
        super(props);
        this.publishTweet = this.publishTweet.bind(this);
    }

    publishTweet() {
        console.log('I have been called');
        let text = document.getElementById('helloWorldHeader').innerHTML;
        console.log('This is my text: ', text);
        publish(text);
    }

    render() {
        return (
            <div>
                <h1 id='helloWorldHeader'>Hello World!</h1>
                <input type='button' onClick={() => {this.publishTweet()}} value='I\'m just a simple button/>
            </div>
        );
    }
}

export default myUi;
