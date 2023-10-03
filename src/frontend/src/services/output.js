class Output {

    constructor(category, count, price, type, deepground) {
        this._category = category;
        this._count = count;
        this._price = price;
        this._type = type;
        this._deepground = deepground;
    }


    get category() {
        return this._category;
    }

    set category(value) {
        this._category = value;
    }

    get count() {
        return this._count;
    }

    set count(value) {
        this._count = value;
    }

    get price() {
        return this._price;
    }

    set price(value) {
        this._price = value;
    }

    get type() {
        return this._type;
    }

    set type(value) {
        this._type = value;
    }


    get deepground() {
        return this._deepground;
    }

    set deepground(value) {
        this._deepground = value;
    }
}

export default Output;