import React from 'react'
import { Provider } from 'react-redux';
import App from './App';
import ReactDOM from 'react-dom';


// router
import { PersistGate } from "redux-persist/integration/react";
import { store, persistor } from "./store";
import { Router } from "react-router";
import history from "./utils";

ReactDOM.render(
  <Provider store={store}>
    <PersistGate loading={null} persistor={persistor}>
      <Router history={history}>
        <App />
        </Router>
      </PersistGate>
  </Provider>,
  document.getElementById("root")
);

