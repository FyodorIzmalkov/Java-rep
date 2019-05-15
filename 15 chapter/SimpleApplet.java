assert condition; 
Here, condition is an expression that must evaluate to a Boolean result. 
If the result is true, then the assertion is true and no other action takes place. 
If the condition is false, then the assertion fails and a default AssertionError object is thrown. 
For example, assert n > 0; If n is less than or equal to zero, then an AssertionError is thrown. 
Otherwise, no action takes place. The second form of assert is shown here: assert condition : expr; 