import Input from "./input/Index";
import Textarea from "./textarea/Index";



export const formInput = ({
    type,
  placeholder,
  disabled,
  input,
  meta,
  label,
  leftIcon,
  rightIcon,
  defaultValue,
}) => {
    return (
        <>
        <Input 
        {...input}
        
        label={label}
        type={type}
        defaultValue={defaultValue}
        placeholder={placeholder}
        isError={meta.touched && meta.error}
        isValid={meta.valid}
        leftIcon={leftIcon}
        rightIcon={rightIcon}
        />
        <div className="mb-1"></div>
        <span className="form-validation">{meta.touched && meta.error}</span>
        <div className="mb-1"></div>

        </>
    )
}


export const formTextarea = ({
    type,
    placeholder,
    disabled,
    input,
    meta,
    label,
    leftIcon,
    rightIcon,
    defaultValue,
    rows,
  }) => {
    return (
      <>
        <Textarea
          {...input}
          label={label}
          type={type}
          defaultValue={defaultValue}
          disabled={disabled}
          placeholder={placeholder}
          isError={meta.touched && meta.error}
          isValid={meta.valid}
          leftIcon={leftIcon}
          rightIcon={rightIcon}
          rows={rows}
        />
        <div className="mb-1"></div>
        <span className="form-validation">{meta.touched && meta.error}</span>
        <div className="mb-1"></div>
      </>
    );
  };
  
    