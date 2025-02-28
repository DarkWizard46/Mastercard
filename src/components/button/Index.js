import { Button } from "react-bootstrap";
import React from "react";

const Index = ( {
    title,
    disabled,
    size,
    color = "primary",
    variant,
    type,
    onClick,
    light,
}) => {
    let variants = variant ? variant + " " : "";
    return (
        <Button
      className={`my-2 ${light ? "text-white" : "text-dark"}`}
      disabled={disabled}
      variant={variants + color}
      size={size}
      type={type}
      onClick={onClick}>
      {title}
    </Button>
  );
};

export default Index;