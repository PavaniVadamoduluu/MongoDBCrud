package com.SampleMongoDB.exception;

import java.util.List;

@XmlRootElement(name = "error")
public class ErrorResponse 
{
    public ErrorResponse(String message, List<String> error) {
        super();
     //   this.message = message;
        this.error = error;
    }
 
    //General error message about nature of error
  //  private String message;
 
    //Specific errors in API request processing
    private List<String> error;

//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}

	public List<String> geterror() {
		return error;
	}

	public void seterror(List<String> error) {
		this.error = error;
	}
 
}
