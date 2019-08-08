import React, {Component} from 'react';
import {publish} from './functions';

class myUi extends Component {

    constructor(props) {
        super(props);
        this.publishTweet = this.publishTweet.bind(this);
    }

    publishTweet() {
        console.log('I have been called');
        //This is where the message should be gotten
        //and then passed on to publish.
        //publish is a function that accept a
        //single parameter called message and returns nothing.
    }

    render() {
        return (
            <div>
                <h1>Hello World!</h1>
                <input type='button' onClick={() => {this.publishTweet()}} value='I wont do anything'/>
            </div>
        );
    }
}

export default myUi;
