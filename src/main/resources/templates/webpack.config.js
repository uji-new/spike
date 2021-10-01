var path = require('path');

module.exports = {
    cache: true,
    entry: './app.js',
    mode: 'production',
    output: {
        path: __dirname,
        filename: '../static/app.js'
    },
    module: {
        rules: [
            {
                test: __dirname,
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            }
        ]
    }
};