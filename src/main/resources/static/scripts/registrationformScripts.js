// const userName = document.querySelector('#inputUserName4');
// const email = document.querySelector('#inputEmail4');
// const password = document.querySelector('#inputPassword4');
// const address = document.querySelector('#inputAddress');
// const city = document.querySelector('#inputCity');
// const zipCode = document.querySelector('#inputZip');

// const form = document.querySelector('#registrationForm');

//Creating validation utility functions
function isRequired (value) {
    if (value === '') {
        return false;
    } else {
        return true;
    }
}
function isBetween(length, min, max) {
    if (length < min || length > max) {
        return false;
    } else {
        return true;
    }
}
function isEmailValid(email) {
    const emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return emailPattern.test(email);
}

function isPasswordSecure(password) {
    const passwordPattern = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return passwordPattern.test(password);
}

//Creating error and success functions
function showError(input, errorMessage) {
    const formGroup = input.parentElement;

    formGroup.classList.remove('success')
    formGroup.classList.add('error')

    const error = formGroup.querySelector('small');
    error.textContent = errorMessage;
}

function showSuccess(input) {
    const formGroup = input.parentElement;

    formGroup.classList.remove('error');
    formGroup.classList.add('success');

    const error = formGroup.querySelector('small');
    error.textContent = '';
}

//Creating validation functions
const checkUsername = function () {
    let valid = false;
    const min = 3;
    const max = 20;

    const usernameInput = document.querySelector('#inputUserName4');
    const usernameValue = usernameInput.value.trim();

    if (!isRequired(usernameValue)) {
        showError(usernameInput, 'Username cannot be empty');
        return { valid: false, message: 'Username cannot be empty' };
    } else if (!isBetween(usernameValue.length, min, max)) {
        showError(usernameInput, `Username must be between ${min} and ${max} characters`)
        return { valid: false, message: `Username must be between ${min} and ${max} characters`};
    } else {
        showSuccess(usernameInput);
        return { valid: true, message: '' };
    }
    return valid;
}

const checkEmail = function () {
    let valid = false;

    const emailValueInput = document.querySelector('#inputEmail4');
    const emailValue = emailValueInput.value.trim();

    if (!isRequired(emailValue)) {
        showError(emailValueInput, 'Email address cannot be empty');
        return { valid: false, message: 'Email address cannot be empty'};
    } else if (!isEmailValid(emailValue)) {
        showError(emailValueInput, 'Please enter a valid email address');
        return { valid: false, message: 'Please enter a valid email address' };
    } else {
        showSuccess(emailValueInput)
        return { valid: true, message: '' };
    }
    return valid;

}

const checkPassword = function () {
    let valid = false;

    const passwordValueInput = document.querySelector('#inputPassword4');
    const passwordValue = passwordValueInput.value.trim();

    if (!isRequired(passwordValue)) {
        showError(passwordValueInput, 'Password cannot be empty');
        return {valid: false, message: 'Password cannot be empty'};
    } else if (!isPasswordSecure(passwordValue)) {
        showError(passwordValueInput, 'Password must have at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)');
        return {valid: false, message: 'Password must have at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)'};
        } else {
        showSuccess(passwordValueInput)
        return { valid: true, message: '' };
    }
    return valid;
}

const checkAddress = function () {
    let valid = false;

    const addressValueInput = document.querySelector('#inputAddress');
    const addressValue = addressValueInput.value.trim();

    if (!isRequired(addressValue)) {
        showError(addressValueInput, 'Address cannot be empty');
        return { valid: false, message: 'Address cannot be empty'};
    } else {
        showSuccess(addressValueInput)
        return { valid: true, message: '' };
    }
    return valid;
}

const checkCity = function () {
    let valid = false;

    const cityValueInput = document.querySelector('#inputCity');
    const cityValue = cityValueInput.value.trim();

    if (!isRequired(cityValue)) {
        showError(cityValueInput, 'City cannot be empty');
        return { valid: false, message: 'City cannot be empty'};
    } else {
        showSuccess(cityValueInput)
        return { valid: true, message: '' };
    }
    return valid;
}

const checkZipcode = function () {
    let valid = false;

    const zipcodeValueInput = document.querySelector('#inputZip');
    const zipcodeValue = zipcodeValueInput.value.trim();

    if (!isRequired(zipcodeValue)) {
        showError(zipcodeValueInput, 'Postcode cannot be empty');
        return { valid: false, message: 'Postcode cannot be empty'};
    } else {
        showSuccess(zipcodeValueInput)
        return { valid: true, message: '' };
    }
    return valid;
}


document.getElementById('registrationForm').addEventListener('submit', function (event) {
        event.preventDefault();

        let isUsernameValid = checkUsername(),
            isEmailValid = checkEmail(),
            isPasswordValid = checkPassword(),
            isAddressValid = checkAddress(),
            isCityValid = checkCity(),
            isZipcodeValid = checkZipcode();

    let isFormValid = isUsernameValid.valid && isEmailValid.valid && isPasswordValid.valid && isAddressValid.valid && isCityValid.valid && isZipcodeValid.valid;

    if (isFormValid) {
        const form = document.getElementById('registrationForm')

        form.submit();
    } else {
        return null;
    }


});

document.getElementById('registrationForm').addEventListener('input', function (event) {
    const targetId = event.target.id;

    switch (targetId) {
        case 'inputUserName4':
            const usernameResult = checkUsername();
            document.querySelector('#userNameError').innerHTML = usernameResult.valid ? '' : usernameResult.message;
            break;
        case 'inputEmail4':
            const emailResult = checkEmail();
            document.querySelector('#emailError').innerHTML = emailResult.valid ? '' : emailResult.message;
            break;
        case 'inputPassword4':
            const passwordResult = checkPassword();
            document.querySelector('#passwordError').innerHTML = passwordResult.valid ? '' : passwordResult.message;
            break;
        case 'inputAddress':
            const addressResult = checkAddress();
            document.querySelector('#addressError').innerHTML = addressResult.valid ? '' : addressResult.message;
            break;
        case 'inputCity':
            const cityResult = checkCity();
            document.querySelector('#cityError').innerHTML = cityResult.valid ? '' : cityResult.message;
            break;
        case 'inputZip':
            const zipCodeResult = checkZipcode();
            document.querySelector('#zipCodeError').innerHTML = zipCodeResult.valid ? '' : zipCodeResult.message;
            break;
    }
});

