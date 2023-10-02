class Output {

    constructor(count, price, type) {
        this._count = count;
        this._price = price;
        this._type = type;
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
}

export default Output;