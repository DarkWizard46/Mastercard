import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./store/Index";
import Login from "./views/authentication/Login";

const App = () => {
    return (
        <Provider store={store}>
            <Router>
                <Routes>
                    <Route path="/login" element={<Login />} />
                    <Route path="/dashboard" element={<h1>Dashboard</h1>} />
                </Routes>
            </Router>
        </Provider>
    );
};

export default App;
