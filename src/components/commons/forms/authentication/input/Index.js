import React from "react";

const Input = ({ type, placeholder, disabled, value, onChange, style, className, label, leftIcon, rightIcon, error, defaultValue, rule, onKeyPress, maxLength }) => {
  return (
    <div className={`input-wrapper ${error ? "error" : ""}`}>
      <span style={{ fontWeight: "800" }}>{label}</span>
      <div className="input-box-wrapper">
        {leftIcon ? leftIcon : ``}
        <input
          type={type}
          placeholder={placeholder}
          defaultValue={defaultValue}
          rule={rule}
          onChange={onChange}
          className={className}
          value={value}
          disabled={disabled}
          style={{ ...style, fontSize: 14 }}
          onKeyPress={onKeyPress}
          maxLength={maxLength}
        />
        {rightIcon ? rightIcon : ``}
      </div>
      <span className="error-msg">{error}</span>
    </div>
  );
};

export default Input;
