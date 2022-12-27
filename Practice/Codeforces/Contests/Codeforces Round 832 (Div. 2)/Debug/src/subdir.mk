################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/A.cpp \
../src/B.cpp \
../src/C.cpp \
../src/D.cpp 

CPP_DEPS += \
./src/A.d \
./src/B.d \
./src/C.d \
./src/D.d 

OBJS += \
./src/A.o \
./src/B.o \
./src/C.o \
./src/D.o 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp src/subdir.mk
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


clean: clean-src

clean-src:
	-$(RM) ./src/A.d ./src/A.o ./src/B.d ./src/B.o ./src/C.d ./src/C.o ./src/D.d ./src/D.o

.PHONY: clean-src

