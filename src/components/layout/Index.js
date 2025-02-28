import React, { useState } from "react";
import { connect, useDispatch } from "react-redux";
import Sidebar from "./sidebar";

const Index = ({ children }) => {
  return (
    <div>
      <Sidebar />
      <div className="main-content">{children}</div>
    </div>
  );
};

const mapStateToProps = ({}) => {
  return {};
};

const mapDispatchToProps = (dispatch) => {
  return {};
};

export default connect(mapStateToProps, mapDispatchToProps)(Index);
