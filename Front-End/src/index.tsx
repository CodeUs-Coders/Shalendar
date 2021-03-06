import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom'
import App from './App';
import * as serviceWorker from './serviceWorker';
import { StylesProvider } from '@material-ui/core/styles';

ReactDOM.render(
  <StylesProvider injectFirst>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </StylesProvider>, document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
