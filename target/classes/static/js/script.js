document.addEventListener('DOMContentLoaded', function () {
    const cart = document.getElementById('cart');
    const cartItemsContainer = document.getElementById('cart-items');
    const totalPriceElement = document.getElementById('total-price');
    const carritoIcono = document.getElementById('carrito-icono');
    const closeCartButton = document.getElementById('close-cart');
    const addToCartButtons = document.querySelectorAll('.add-to-cart');

    let cartItems = [];
    let totalPrice = 0;

    function updateCart() {
        cartItemsContainer.innerHTML = '';
        cartItems.forEach(item => {
            const cartItem = document.createElement('div');
            cartItem.classList.add('cart-item');
            cartItem.innerHTML = `<p>${item.name} - S/. ${item.price.toFixed(2)} x ${item.quantity}</p>`;
            cartItemsContainer.appendChild(cartItem);
        });
        totalPriceElement.textContent = `Total: S/. ${totalPrice.toFixed(2)}`;
    }

    addToCartButtons.forEach(button => {
        button.addEventListener('click', function (e) {
            e.preventDefault();
            const name = button.getAttribute('data-name');
            const price = parseFloat(button.getAttribute('data-price'));

            const existingItem = cartItems.find(item => item.name === name);
            if (existingItem) {
                existingItem.quantity += 1;
                existingItem.price += price;
            } else {
                cartItems.push({
                    name: name,
                    price: price,
                    quantity: 1
                });
            }

            totalPrice += price;
            cart.style.display = 'block';
            updateCart();
        });
    });

    carritoIcono.addEventListener('click', function () {
        cart.style.display = cart.style.display === 'none' ? 'block' : 'none';
    });

    closeCartButton.addEventListener('click', function () {
        cart.style.display = 'none';
    });
});
