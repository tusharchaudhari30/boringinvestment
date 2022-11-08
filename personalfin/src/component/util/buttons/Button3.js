import React, { Component } from "react";
import "./button.scss";
export default class Button3 extends Component {
  render() {
    return (
      <button
        className={"btn " + this.props.className}
        onClick={this.props.onpress}
      >
        {this.props.children}
      </button>
    );
  }
}
