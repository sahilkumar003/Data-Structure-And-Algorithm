Array.prototype.last = function() {
    let a = this[this.length-1];
    return a!=undefined ? a : -1;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */