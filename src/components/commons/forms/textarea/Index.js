import React from "react";

const Textarea = ({ type, placeholder, disabled, value, onChange, style, className, label, leftIcon, rightIcon, isError, defaultValue, rows, error }) => {
  return (
    <div className={`input-wrapper ${error ? "error" : ""}`}>
      {/* {label && <label className="form-label">{label}</label>} */}
      <span style={{ fontWeight: "800" }}>{label}</span>
      <div className="textarea-wrapper">
        {leftIcon && <span className="material-icons-round left-icon-input">{leftIcon}</span>}
        <textarea
          placeholder={placeholder}
          className={`form-control ${className || ""} ${rightIcon ? "end-icon" : ""} ${isError ? "is-invalid" : ""}`}
          rows={rows ? rows : 3}
          value={value}
          defaultValue={defaultValue}
          onChange={onChange}
          disabled={disabled}
          style={{ ...style, fontSize: 14 }}
        />
        {rightIcon && <span className="material-icons-round right-icon-input">{rightIcon}</span>}
      </div>
      {isError ? <span className="error-msg error-msg-show">{error}</span> : ``}
    </div>
  );
};

export default Textarea;
