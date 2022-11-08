import React, { Component } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./component/pages/Home";
import Login from "./component/pages/Login";

export default class App extends Component {
  render() {
    return (
      <div className="bg-black w-full min-h-screen text-white select-none">
        <BrowserRouter>
          <Routes>
            <Route exact path="/" element={<Home />} />
            <Route exact path="/login" element={<Login />} />
          </Routes>
        </BrowserRouter>
      </div>
    );
  }
}
