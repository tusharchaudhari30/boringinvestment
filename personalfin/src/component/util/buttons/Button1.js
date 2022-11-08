import React, { Component } from "react";

export default class Button1 extends Component {
  render() {
    return (
      <button
        className="focus:outline-none px-2 py-1 border border-slate-300 hover:bg-slate-200 hover:text-black"
        onClick={this.props.onpress}
      >
        {this.props.value}
      </button>
    );
  }
}
