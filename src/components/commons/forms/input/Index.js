import React from "react";

const InputSecond = ({
  type,
  placeholder,
  disabled,
  value,
  onChange,
  style,
  className,
  label,
  leftIcon,
  rightIcon,
  error,
  defaultValue,
  rule,
  onKeyPress,
  maxLength,
  readOnly,
}) => {
  return (
    <div className={`input-wrapper ${error ? "error" : ""}`}>
      <div className="row">
        <div className="col-md-2 d-flex align-items-center">
          <span style={{ fontWeight: "700", fontSize: "14px" }}>{label}</span>
        </div>
        <div className="col-md-10">
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
              style={style}
              onKeyPress={onKeyPress}
              maxLength={maxLength}
              readOnly={readOnly}
            />
            {rightIcon ? rightIcon : ``}
          </div>
          <span className="error-msg">{error}</span>
        </div>
      </div>
    </div>
  );
};

export default InputSecond;
