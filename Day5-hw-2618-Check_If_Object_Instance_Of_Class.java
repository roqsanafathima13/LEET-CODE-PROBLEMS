/**
 * @param {any} value
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(value, classFunction) {
    if (value == null || classFunction == null) return false;
    if (typeof classFunction !== "function") return false;

    let proto = Object.getPrototypeOf(value);
    while (proto != null) {
        if (proto === classFunction.prototype) {
            return true;
        }
        proto = Object.getPrototypeOf(proto);
    }
    return false;
};
